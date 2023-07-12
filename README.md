# ChatbotWhatsapp
 
 Um bot para WhatsApp que enviará ao usuário uma mensagem com informações básicas sobre cotação de ações quando ele enviar um símbolo de cotação válido.

## Tecnologias utilizadas🛠️

- Java
- Spring Boot
- Maven
- Twillo
- Ngrok
- Twillo

## Funcionalidades⚙️

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
4.Quando o Ngrok estiver em execução, ele exibirá uma URL no formato ```https://```. Copie esse endereço e adicione ```/messages``` ao final, pois esse é o caminho da URL definido no controlador.

![Ngrok](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/ef6d6b25-9bab-41fc-9537-29cf9cac80cd)

5. Crie uma conta Twilio, caso ainda não tenha uma, e acesse a seção "Programmable Messaging" (Mensagens Programáveis) > "Settings" (Configurações) > "WhatsApp Sandbox Settings" (Configurações do Sandbox do WhatsApp).
6. Cole o link seguro do Ngrok na opção "When a message comes in" (Quando uma mensagem chegar), na janela do webhook.

![Twillo](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/065e9b98-a80e-49cc-aa72-b5857aa26080)

7. Crie uma conta da Finnhub.io para obter uma chave API.
8. Copie a chave de API do painel da Finnhub.io e defina-a como uma variável de ambiente em seu sistema.

![imagem_2023-07-12_120436194](https://github.com/SamuelMartins21/ControleDeGastos/assets/122890386/b67a987f-7940-45b1-bcbd-2476343a3492)

A definição de variáveis de ambiente pode ser realizada de diferentes formas. Você pode consultar o seguinte link para obter informações sobre como definir variáveis de ambiente: [Como definir variáveis de ambiente](https://www.twilio.com/blog/how-to-set-environment-variables.html)


Tudo configurado corretamente e já está pronto para uso
