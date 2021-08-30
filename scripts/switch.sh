#!/usr/bin/env bash

#nginx 설정
SCRIPT_DIR=$(dirname $(realpath $0))
source ${SCRIPT_DIR}/profile.sh


function switch_proxy() {
    if [ "$ENV" = "dev" ]
    then
      IDLE_PORT=${DEV_SERVER_PORT}
    else
      IDLE_PORT=$(find_idle_port)
    fi

    echo ">> Switch :: 전환할 Port: $IDLE_PORT"
    echo ">> Switch :: Port 전환"
    # 아래 줄은 보면 echo를 통해서 나온 결과를 | 파이프라인을 통해서 service-url.inc에 덮어쓸 수 있다.
    echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc
    echo ">> Switch :: Nginx Reload"
    sudo service nginx reload
}
