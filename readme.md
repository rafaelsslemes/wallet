# Teste Wallet #

## Design de Arquitetura ##

![image info](./applications_architecture.png)

Obs.: Os componentes em amarelo não foram implemetados, somente idealizados

## Para executar os Projetos ##

Acesse a raiz do repositório e execute:
```
docker-compose -p teste up -d
```

## Acesso à documentação e teste dos Endpoints ##

account-ms: http://localhost:8000/swagger-ui/index.html  
deposit-ms: http://localhost:8010/swagger-ui/index.html  
withdraw-ms: http://localhost:8020/swagger-ui/index.html  
transfer-ms: http://localhost:8030/swagger-ui/index.html  
payment-ms: http://localhost:8040/swagger-ui/index.html  
transactions-ms: http://localhost:8050/swagger-ui/index.html  
