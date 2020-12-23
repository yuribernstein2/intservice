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

'''
 for sentiment in ; do
   sudo docker run superhero -w spiderman | grep spiderman
   check_result $sentiment
 done
'''
exit 0


}