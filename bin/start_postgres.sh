#!/usr/bin/env bash

set -euo pipefail
which psql > /dev/null || (echoerr "Please ensure that postgres client is in your PATH" && exit 1)

docker-compose up sql-db
