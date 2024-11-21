# Chatbot para Transcrição de Áudio e Respostas Baseadas em Similaridade

Este projeto implementa um chatbot que utiliza inteligência artificial para transcrever áudios enviados pelo usuário via Telegram e retornar respostas relevantes com base em uma base de dados textual. Além disso, a resposta mais relevante pode ser convertida em áudio e enviada de volta ao usuário.

O bot foi desenvolvido utilizando as bibliotecas `telebot`, `whisper`, `faiss`, `gtts` e outras ferramentas modernas para processamento de linguagem natural e geração de áudio.

## Link para o Google Colab

Você pode acessar o projeto completo no Google Colab através deste [link](https://colab.research.google.com/drive/1QQeiCR0Bda9osleDQrgPFTNvnqkYTy3f?usp=sharing).

## Configurando o Telegram

Para configurar o Telegram no seu celular:

1. Baixe e instale o aplicativo do Telegram a partir da loja de aplicativos do seu dispositivo.
2. Crie uma conta ou faça login com sua conta existente.
3. Procure por "@BotFather" e inicie uma conversa.
4. Use o comando `/newbot` para criar um novo bot e siga as instruções fornecidas pelo BotFather.
5. Após a criação do bot, você receberá um token de API. **Guarde este token, pois ele será necessário para configurar o bot no código.**

## Configurando o Token do Bot

No código do Google Colab, há uma parte onde você deve inserir o token do seu bot do Telegram. Procure pela linha que contém:

```python
API_TOKEN = 'insira-o-token-aqui'
```
Substitua `insira-o-token-aqui` pelo token que você recebeu do BotFather.

## Executando o Código

Para executar o código no Google Colab:

1. Abra o notebook no Google Colab usando o link fornecido.
2. Aperte `Ctrl+F9` para executar todas as células do notebook.
3. Aguarde até que todas as células sejam executadas e o código tenha terminado de rodar. Note que a última célula, que inicia o bot, permanecerá em execução, o que significa que o bot está ativo e pronto para receber mensagens.

O bot estará pronto para uso. Você pode começar a interagir com ele através do bot do Telegram que você criou.

## Funcionalidades do Bot

O bot implementa as seguintes funcionalidades principais:

1. **Transcrição de Áudio:**
   - O bot aceita áudios enviados pelos usuários e transcreve o conteúdo usando o modelo Whisper.

2. **Busca Baseada em Similaridade:**
   - O texto transcrito é comparado com uma base de dados textual utilizando embeddings gerados pela biblioteca `sentence-transformers` e busca vetorial com FAISS.
   - O resultado mais relevante é retornado ao usuário.

3. **Geração de Áudio com GTTS:**
   - A resposta mais relevante é convertida em áudio utilizando o Google Text-to-Speech (GTTS) e enviada de volta ao usuário no formato `.ogg`.

4. **Envio de Áudio no Telegram:**
   - O bot envia a resposta em áudio para o usuário, permitindo uma interação mais acessível.

## Tecnologias Utilizadas

- **Python:** Linguagem principal do projeto.
- **Whisper:** Utilizado para transcrição de áudios.
- **FAISS:** Para busca vetorial e comparação de similaridade.
- **GTTS:** Para conversão de texto em áudio.
- **Telebot:** Para integração com o Telegram.
- **Google Colab:** Para desenvolvimento e execução do código em nuvem.

## Como Modificar o Projeto

1. **Base de Dados Textual:**
   - A base de textos utilizada para busca por similaridade pode ser modificada no código. Basta editar a lista `textos` para incluir os conteúdos desejados.

2. **Modelos de Transcrição e Similaridade:**
   - O modelo de transcrição pode ser alterado ajustando os parâmetros do Whisper.
   - O modelo de embeddings pode ser substituído por outro disponível na biblioteca `sentence-transformers`.

