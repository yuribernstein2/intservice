#!/bin/bash
TAG=$1

check_result () {
  RESULT=$?
  MESSAGE=$1
  if [ $RESULT == 0 ]; then
    echo [SUCCESS] $MESSAGE
  else
    echo [FAIL] $MESSAGE
    exit 1
  fi
}

for sentiment in positive negative neutral; do
  sudo docker run $TAG -w $sentiment | grep $sentiment
  check_result $sentiment
done

exit 0