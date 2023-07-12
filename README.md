# ChatbotWhatsapp
 
 Um bot para Whatsapp que enviará ao usuário uma mensagem com informações básicas sobre cotação de ações quando ele enviar um símbolo de cotação válido.

## Tecnologias utilizadas🛠️

- Java
- Spring Boot
- Maven
- Twillo
- Ngrok
- Twillo

## Funcionalidades⚙️

1. Ao enviar uma mensagem pela primeira vez para o bot, você receberá uma mensagem de boas-vindas.

![Teste 1](https://github.com/SamuelMartins21/ChatbotWhatsapp/assets/122890386/b0e43f3c-b67f-4b0e-98f2-3a72a894023b)

2. Ao enviar uma mensagem pela segunda vez, o bot irá verificar se é um símbolo de cotação válido.

![Teste 2](https://github.com/SamuelMartins21/ChatbotWhatsapp/assets/122890386/369851a6-a928-4ad1-baf6-aa557ca77660)

3. Se você digitar uma mensagem que não corresponda a uma cotação válida ou se essa cotação não estiver disponível, uma mensagem de erro será retornada.

![Teste 3](https://github.com/SamuelMartins21/ChatbotWhatsapp/assets/122890386/27f248ee-5187-4716-b414-bf6b113a024c)

## Como executar o projeto ▶️

Siga as instruções abaixo para executar o projeto em seu ambiente local:

### Pré-requisitos

- JDK (Java Development Kit) instalado
- Ngrok instalado
- Conta Twilio configurada
- Conta Finnhub.io configurada

1. Clone o repositório do GitHub em seu ambiente local
2. Navegue até o arquivo raiz de seu aplicativo (provavelmente algo como ```whatsappbot```). Execute o seguinte comando para iniciar o servidor: ```./mvnw spring-boot:run```
3. Em uma nova janela de terminal, navegue até onde o ngrok está instalado e execute o comando ```ngrok http 8080```
4. Quando o Ngrok estiver em execução, ele exibirá uma URL no formato ```https://```. Copie esse endereço e adicione ```/messages``` ao final, pois esse é o caminho da URL definido no controlador.

![Ngrok](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/ef6d6b25-9bab-41fc-9537-29cf9cac80cd)

5. No Twilio acesse a seção "Programmable Messaging" (Mensagens Programáveis) > "Settings" (Configurações) > "WhatsApp Sandbox Settings" (Configurações do Sandbox do WhatsApp).
6. Cole o link seguro do Ngrok na opção "When a message comes in" (Quando uma mensagem chegar), na janela do webhook.

![Twillo](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/065e9b98-a80e-49cc-aa72-b5857aa26080)

7. Copie a chave de API do painel da Finnhub.io e defina-a como uma variável de ambiente em seu sistema.

![imagem_2023-07-12_122341467](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/23bba373-c1ab-43c9-ab15-ed18d737351e)

- A definição de variáveis de ambiente pode ser realizada de diferentes formas. Você pode consultar o seguinte link para obter informações sobre como definir variáveis de ambiente: [Como definir variáveis de ambiente](https://www.twilio.com/blog/how-to-set-environment-variables.html)

8. Siga a instrução do site para iniciar uma conversa com o chat

![imagem_2023-07-12_140253684](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/efc9533b-b7e9-4774-b368-feab8d942e28)

Tudo configurado corretamente e já está pronto para uso
