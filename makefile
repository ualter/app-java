.DEFAULT_GOAL:=help
SHELL:=/bin/bash
.PHONY: help build test upgrade run

MODULE_NAME=app-java
#VERSION=1.0.1

help:  ## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[33m\n\nTargets:\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-30s\033[33m %s\n", $$1, $$2 }' $(MAKEFILE_LIST)

compile: check-tools ## Compile
	@echo ""; \
	printf " \033[36mCompiling...\033[0m \033[33m\033[0m\n"; \
	printf " \033[36m --> \033[33m$ ${MODULE_NAME}\033[0m \033[33m\033[0m\n"; \
	mvn compile; \
	printf " \033[36mDone!\033[0m"; \

package: check-tools ## Clean, compile and package
	@echo ""; \
	printf " \033[36mPackaging...\033[0m \033[33m\033[0m\n"; \
	printf " \033[36m --> \033[33m$ ${MODULE_NAME}\033[0m \033[33m\033[0m\n"; \
	mvn clean compile package; \

run: check-tools package ## Run locally
	@echo ""; \
	printf " \033[36mRunning...\033[0m \033[33m\033[0m\n"; \
	printf " \033[36m --> \033[33m$ ${MODULE_NAME}\033[0m \033[33m\033[0m\n"; \
	java -jar ./target/app-1.0.0.jar

docker_build: check-tools ## Build Docker Iamge
	@echo ""; \
	printf " \033[36mDocker Build...\033[0m \033[33m\033[0m\n"; \
	printf " \033[36m --> \033[33m$ ${MODULE_NAME}\033[0m \033[33m\033[0m\n"; \
	docker build -t app-java .

check-env: check-tools ## Check environment tooling
	@echo ""; \
	printf "\033[33m OK!\033[0m\n"; \
	echo ""

check-tools: # Check if the necessary tools are installed
ifneq (,$(which java))
	$(error "Java not installed!")
endif
ifneq (,$(which mvn))
	$(error "Maven not installed!")
endif


