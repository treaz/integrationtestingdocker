#!/bin/bash
set -e
set -o pipefail

instruction()
{
  echo "usage: ./build.sh int-test"
}

if [ $# -eq 0 ]; then
  instruction
  exit 1
elif [ "$1" = "int-test" ] && [ $# -eq 1 ]; then
  mvn clean

  mvn verify
else
  instruction
  exit 1
fi