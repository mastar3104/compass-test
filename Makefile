.PHONY: build

build:
	docker build ./ -t compass-test
run:
	docker-compose -f ./local-docker-compose.yaml up -d
dev:
	make build
	make run
stop:
	docker-compose -f ./local-docker-compose.yaml down