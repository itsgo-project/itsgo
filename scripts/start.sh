#!/usr/bin/env bash

SCRIPT_DIR=$(dirname $(realpath $0))
source ${SCRIPT_DIR}/profile.sh

echo ">> Start :: Build"
echo ">> Start :: cp $REPOSITORY/build/*.jar $REPOSITORY/"

cp $REPOSITORY/build/*.jar $REPOSITORY/

echo ">> Start :: 새로운 Application 배포"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo ">> Start :: $JAR_NAME 권한 변경"

chmod +x $JAR_NAME

if [ "$ENV" = "dev" ]
then
  IDLE_PROFILE=dev
else
  IDLE_PROFILE=$(find_idle_profile)
fi


echo ">> Start :: $JAR_NAME 를 profile=$IDLE_PROFILE 로 실행"
nohup java -jar \
    -Dspring.profiles.active=$IDLE_PROFILE \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
