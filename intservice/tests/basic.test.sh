#!/bin/bash
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
  docker run intservice -w $sentiment | grep $sentiment
  check_result $sentiment
done

exit 0