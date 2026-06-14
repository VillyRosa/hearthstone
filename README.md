# Hearthstone API

### Descrição
API REST para gerenciamento de cartas do jogo Hearthstone.

### Permite:
- Cadastrar cartas
- Consultar cartas
- Filtrar cartas
- Atualizar cartas
- Excluir cartas

### Tecnologias:
- Java 21
- Spring Boot 4
- Spring Data JPA
- H2 Database
- Flyway
- Bean Validation
- Maven

### Execução do projeto

#### Requisitos
- Java 21 ou superior

#### Clonar o repositório

```
git clone https://github.com/VillyRosa/hearthstone.git
cd hearthstone
```

#### Executar
```
./mvnw spring-boot:run
```

ou

```
mvn spring-boot:run
```

### Banco de dados
O projeto utiliza o banco H2.

#### Console:
```
http://localhost:8080/h2-console
```

#### Configurações:
```
JDBC URL: jdbc:h2:file:./data/hearthstone
User Name: sa
Password:
```

### Endpoints

#### Buscar todas as cartas
```
GET /carta
```

#### Buscar carta por id
```
GET /carta/{id}
```

#### Criar carta
```
POST /carta
```

#### Atualizar carta
```
PUT /carta/{id}
```

#### Deletar carta
```
DELETE /carta/{id}
```

#### Filtros
```
GET /carta?nome=Bola
GET /carta?classe=MAGO
GET /carta?tipo=MAGIA
```

Também é possível combinar filtros:
```
GET /carta?nome=Bola&classe=MAGO&tipo=MAGIA
```

### Regras de validação
- Nome obrigatório
- Descrição obrigatória
- Custo de mana entre 0 e 10
- Ataque entre 0 e 10
- Defesa entre 0 e 10
- Classe obrigatória
- Tipo obrigatório

### Tratamento de erros
- Dados inválidos
- Carta não encontrada
- Valores inválidos para enums

### Collection Postman
```
https://bold-firefly-298286.postman.co/workspace/hearthstone~28d1aace-5281-4369-80e7-4916b80961c1/collection/19781427-34718199-26b0-449b-8577-dc54aaefae1d?action=share&source=copy-link&creator=19781427
```

### Exemplo de Payload
```
{
  "nome": "Bola de Fogo",
  "descricao": "Causa dano ao inimigo",
  "custoMana": 4,
  "ataque": 6,
  "defesa": 2,
  "tipo": "MAGIA",
  "classe": "MAGO"
}
```

### Próximos passos

Possíveis melhorias para evolução do projeto:

- Implementação da entidade Baralho.
- Limite de até 30 cartas por baralho.
- Restrição de no máximo duas cartas iguais por baralho.
- Associação entre cartas e baralhos.
