# Amantes do Futebol

API REST para cadastrar pessoas fãs de futebol e registrar suas preferências e hábitos relacionados ao esporte.

## Tecnologias

- Java 17
- Spring Boot 3.5.3
- Spring Web, Spring Data JPA e Bean Validation
- PostgreSQL
- Maven

## Dados de uma pessoa fã

Cada registro contém `id`, `name`, `email`, `birthDate`, `gender`, `favoriteTeamId`, `city`, `state`, `country` e `stadiumFrequency`. O time favorito referencia o catálogo fixo dos 20 participantes da Série A de 2026. A frequência aceita `SEMPRE`, `AS_VEZES`, `RARAMENTE` ou `NUNCA`. A data de nascimento deve estar no passado e o e-mail deve ser válido e único.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/v1/fans` | Cadastra uma pessoa |
| `GET` | `/api/v1/fans` | Lista todas as pessoas |
| `GET` | `/api/v1/fans/{id}` | Consulta uma pessoa |
| `PUT` | `/api/v1/fans/{id}` | Atualiza todos os dados |
| `DELETE` | `/api/v1/fans/{id}` | Exclui uma pessoa |
| `GET` | `/api/v1/teams` | Lista os times permitidos para seleção |

Exemplo de corpo para criação ou atualização:

```json
{
  "name": "Ana Silva",
  "email": "ana@example.com",
  "birthDate": "1995-04-20",
  "gender": "Feminino",
  "favoriteTeamId": "FLA",
  "city": "Rio de Janeiro",
  "state": "RJ",
  "country": "Brasil",
  "stadiumFrequency": "AS_VEZES"
}
```

O catálogo usa IDs estáveis formados pelas siglas dos clubes. O cadastro rejeita qualquer ID que não esteja nesse catálogo.

## Executar localmente

Crie o banco `amantes_do_futebol` no PostgreSQL (ou configure `DB_URL`, `DB_USERNAME` e `DB_PASSWORD`) e execute:

```bash
./mvnw spring-boot:run
```

A API inicia em `http://localhost:8080`. A documentação OpenAPI fica disponível em `/swagger-ui.html`.
