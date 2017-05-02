# vinho


Venda de Vinhos

Após baixar o projeto, fazer import como mavem project.
use install -DskipTests para gerar o jar

Use a classe VinhoApplication para rodar como java Application

Para testar os serviços use uma ferramenta Rest web como Rest Web Client 

Cadastro de Clientes

use o link http://localhost:8080/api/cliente/cadastra
Method POST e no body copie e cole o conteudo do arquivo jsonClientes.txt
clique no botao SEND



Cadastro de Compras


use o link http://localhost:8080/api/compra/cadastra
Method POST e no body copie e cole o conteudo do arquivo jsonClientes.txt

clique no botao SEND



# 1 - Liste os clientes ordenados pelo maior valor total em compras


use o link http://localhost:8080/api/compra/totalCompras

Method GET
clique no botao SEND


# 2 - Mostre o cliente com maior compra única no último ano (2016).



use o link http://localhost:8080/api/compra/compraUnica

Method GET
clique no botao SEND


# 3 - Liste os clientes mais fiéis.



use o link http://localhost:8080/api/cliente/fieis


Method GET
clique no botao SEND


Irá mostrar os 5 clientes com mais compras realizadas (Top 5)



# 4 - Recomende um vinho para um determinado cliente a partir do histórico
de compras.


use o link http://localhost:8080/api/item/recomendaVinho/000.000./000-01

Method GET
clique no botao SEND

onde /000.000./000-01 = cpf 000.000.000-01 para cpf 000.000.000-02 use /000.000./000-02

O logica utilizada para sugerir um vinho é filtrar nos itens variedade e/ou pais e/ou  Categoria

Primeiro verifica o que mais aparece se variedade , pais ou categoria
após é aplicado os filtros









