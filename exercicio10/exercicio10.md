# Exercício 10: Modelagem REST

### Casos de uso:

- Usuário compartilha uma foto.
- Usuário comenta em uma foto.

### Recursos

- `fotos`
- `comentarios`

### Endpoints

| Descrição                           | URI                                          | Método HTTP | Corpo                                                      | Resposta Esperada | Erros esperados                              |
|-------------------------------------|----------------------------------------------|-------------|------------------------------------------------------------|-------------------|----------------------------------------------|
| Retornar todas as fotos do usuário  | `GET /usuarios/{usuario-id}/fotos`          | `GET`       | Vazio                                                      | `200 OK`          | `404 Not Found` - usuário não encontrado.   |
| Retornar uma foto específica        | `GET /fotos/{foto-id}`                      | `GET`       | Vazio                                                      | `200 OK`          | `404 Not Found` - foto não encontrada.      |
| Inserir nova foto                   | `POST /usuarios/{usuario-id}/fotos`         | `POST`      | `{ "descricao": "Praia", "url": "link-da-imagem.jpg" }` | `201 Created`     | `404 Not Found` - usuário não encontrado.   |
| Atualizar descrição da foto         | `PATCH /fotos/{foto-id}`                      | `PATCH`       | `{ "descricao": "Praia ao pôr do sol" }`                  | `200 OK`          | `404 Not Found` - foto não encontrada.      |
| Deletar uma foto                    | `DELETE /fotos/{foto-id}`                   | `DELETE`    | Vazio                                                      | `200 OK`          | `404 Not Found` - foto não encontrada.      |
| Retornar comentários da foto        | `GET /fotos/{foto-id}/comentarios`          | `GET`       | Vazio                                                      | `200 OK`          | `404 Not Found` - foto não encontrada.      |
| Inserir comentário em uma foto      | `POST /fotos/{foto-id}/comentarios`         | `POST`      | `{ "usuario": "usuario123", "texto": "Linda foto!" }`    | `201 Created`     | `404 Not Found` - foto não encontrada.      |
| Deletar um comentário               | `DELETE /comentarios/{comentario-id}`       | `DELETE`    | Vazio                                                      | `200 OK`          | `404 Not Found` - comentário não encontrado. |