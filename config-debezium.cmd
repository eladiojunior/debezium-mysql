@REM ----------------------------------------------------------------------------
@REM Configura os connectors do Debezium.
@REM ----------------------------------------------------------------------------

curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://192.168.0.18:8083/connectors/ -d @registra-connector-mysql-debezium.json