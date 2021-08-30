#!/usr/bin/env bash
source ${SCRIPT_DIR}/settings.sh

function find_idle_profile()
{
    # 탄력 ip 할당
    RESPONSE_CODE=$(sudo curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)

    if [ ${RESPONSE_CODE} -ge 400 ] # 400보다 크다면 (Error)
    then
        CURRENT_PROFILE=prod2
    else
        CURRENT_PROFILE=$(sudo curl -s http://localhost/profile)
    fi

    if [ ${CURRENT_PROFILE} == prod1 ]
    then
      IDLE_PROFILE=prod2
    else
      IDLE_PROFILE=prod1
    fi

    echo "${IDLE_PROFILE}"
}

# 쉬고 있는 profile의 port 찾기
function find_idle_port()
{
    IDLE_PROFILE=$(find_idle_profile)

    if [ ${IDLE_PROFILE} == prod1 ]
    then
      echo $PROD1_SERVER_PORT   # 여기도 마찬가지로 return 기능의 느낌
    else
      echo $PROD2_SERVER_PORT    # 여기도 마찬가지로 return 기능의 느낌
    fi
}
