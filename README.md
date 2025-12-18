# Match Estudos (estudo de Design Patterns)

Descrição
- Projeto para estudo do padrão de projeto Observer, implementado em Java.
- Implementa um sistema simples de "match" de estudos: quando um novo aluno demonstra interesse em um tópico, ele é relacionado (match) a outros alunos interessados no mesmo tópico.

## Justificativa técnica dentro do domínio

No contexto do sistema:

● O Subject pode ser o serviço de domínio responsável por gerenciar interesses e cadastros de alunos.

● Os Observers podem ser componentes que reagem a esses eventos, como uma classe responsável por identificar matches ou enviar notificações internas.

Exemplo de situações onde o Observer faz sentido no nosso projeto:

● Quando um novo aluno é registrado com interesse em “Programação”, o sistema pode notificar automaticamente módulos que verificam compatibilidade com alunos já existentes.

● Quando alguém adiciona um novo tópico de estudo, observers podem verificar se esse novo interesse gera matches imediatos.

● Isso permite que a lógica de notificação fique desacoplada do cadastro em si, mantendo a coesão do domínio.


A escolha do Observer não serve exatamente para "notificar as partes interessadas diretamente (como enviar alertas a pessoas)", pois isso já entraria no campo de eventos de aplicação ou mensagens para usuários reais. Porém, dentro da lógica do domínio, ele é apropriado para fazer com que diferentes componentes do sistema reajam automaticamente a mudanças, como a criação de novos matches.

Estrutura do projeto
1. `src/main/java/controllers`
    - `ApplicationController.java` — orquestra fluxo da aplicação (recebe eventos da view, chama serviços).
2. `src/main/java/domain/entities`
    - `Estudante.java` — entidade que representa um aluno.
    - `TopicoEstudo.java` — entidade que representa um tópico/assunto de estudo.
3. `src/main/java/domain/services`
    - `MatchService.java` — lógica de negócios que realiza os matches entre estudantes por tópico.
4. `src/main/java/interfaces`
    - `Publisher.java` — interface para o papel de publicador (observer pattern).
    - `Subscriber.java` — interface para o papel de assinante.
    - `TopicoView.java` — interface para a view relacionada a tópicos.
5. `src/main/java/org/view`
    - `AppView.java` — implementação da interface de visualização; entrada/saída da aplicação (console/GUI conforme implementação).
6. `src/main/resources` — recursos da aplicação (configurações, mensagens, etc).

UML de relação das classes:
<br>
<img src="/images/uml-match-estudos.png" alt="UML do match de estudos" >

Padrões de projeto explorados
- Observer / Publisher-Subscriber: comunicação entre view/controllers e serviços.
- Service: separação da lógica de negócio em `MatchService`.
- MVC/Arquitetura em camadas: `controllers` (controle), `domain` (modelo), `org.view` (visão), `interfaces` (contratos).

Como compilar e executar
- Compilar: `mvn clean package`
- Executar testes: `mvn test`
- Executar a aplicação (IDE recomendado) ou via plugin exec:
    - `mvn exec:java -Dexec.mainClass="org.view.AppView"`

