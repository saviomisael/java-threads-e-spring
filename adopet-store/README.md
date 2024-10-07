Sujeira de Leitura (Dirty Read): Quando uma transação lê dados que foram modificados por outra transação que ainda não foi concluída.

Leitura Não Repetível (Non-Repeatable Read): Quando uma transação lê a mesma linha duas vezes e encontra dados diferentes porque outra transação alterou os dados entre as duas leituras.

Leitura Fantasma (Phantom Read): Quando uma transação reexecuta uma consulta, retornando um conjunto de linhas que satisfazem uma condição e encontra um conjunto de linhas diferente, porque outras transações inseriram ou excluíram linhas que satisfazem a condição.

Lock Pessimista: bloqueia os dados para que ninguém mais possa alterá-los até que a transação atual seja concluída. É como segurar um livro em uma biblioteca e dizer "ninguém mais pode ler isso até que eu termine".

Lock Otimista: permite que outras transações vejam os dados, mas antes de finalizar a transação, o sistema verifica se ninguém mais fez alterações nesse meio tempo. É como se você marcasse a página do livro e, antes de terminar de ler, verificasse se ninguém virou a página enquanto você não estava olhando.

@Version na entidade = Lock Otimista

@Lock(LockModeType.PESSIMISTIC_WRITE) no método do repository = Lock Pessimista

LockModeType.PESSIMISTIC_WRITE = leitura e gravação bloqueantes

[https://www.baeldung.com/java-jpa-transaction-locks](https://www.baeldung.com/java-jpa-transaction-locks)

Para cada requisição para o Spring um thread é criada e cada requisição é bloqueante se não for utilizado o @Async
