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

containerName=$(echo $TAG | cut -d'-' -f2)


sudo docker rm -f $(sudo docker ps -aq)
sudo docker run -d -p 5000:5000 --name $containerName $TAG
sleep 5
for sentiment in positive negative neutral; do
  curl -s -X POST --header "Content-Type: application/json" --data '{"word":"'$sentiment'"}' http://localhost:5000 | grep $sentiment
  check_result $sentiment
done

exit 0
