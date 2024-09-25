# Back-End-Challenge


Realiza o cadastro de clientes na instituição, o cadastro pode ser de PF (Pessoa Física) ou de PJ (Pessoa Jurídica).

Após o cadastro do cliente ser efetuado, será permitido que sejam abertas uma ou mais contas para aquele cadastro.

As contas devem possuir um saldo onde poderão realizar movimentações de pagamentos entre as contas, gerando um débito(saída) para um conta e crédito(entrada) para a outra!

Requisitos Funcionais:
Ambos os tipos de Clientes, devem possuir Nome, CPF/CNPJ, Endereço e Senha. CPF/CNPJ devem ser únicos no sistema.

As Contas, devem possuir Id, Agência, Saldo, Status (Ativa/Inativa). Id e Agência devem ser únicos no sistema.

Validar o status da Conta e se ela possui saldo suficiente para realizar a transferência.

O pagamento é uma operação transacional que pode ser anulada ou revertida, nesse cenário o dinheiro deverá voltar para as contas.

Após efetuar o pagamento, ambos os clientes devem receber uma notificação, o serviço é externo e considere que esse pode falhar ou estar indisponível. Use esse endpoint para o envio (https://run.mocky.io/v3/fc2b4c52-0365-45b2-9005-4cd3a7d989a0).

Construa uma aplicação RESTFul.

Requisitos Técnicos:
Java 17.
Spring Boot.
Spring Data JPA.
