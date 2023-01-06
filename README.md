<h1 align="center">ESTUDIA - POMODORO PARA ESTUDOS</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <br>
  <a href="https://wa.me/+5524981213029"><img alt="WhatsApp" src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"/>     </a>
  <a href="https://www.linkedin.com/in/andr%C3%A9-esperan%C3%A7a/"><img alt="Linkedin" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/></a>
  <a href="mailto:andreluizesperancacorreia@gmail.com"><img alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"/></a>
</p>

<p align="center">  

⭐ Esse é um projeto para demonstrar meu conhecimento técnico no desenvolvimento Android nativo com Kotlin. Mais informações técnicas abaixo.

Aplicativo que permite utilizar o método Pomodoro focado para estudos. Feito com Jetpack Compose com temporizador de preenchimento, notificações e tempo configuráveis.

</p>

</br>
<p float="left" align="center">
<img alt="screenshot" width="30%" src="assets/panelControlScreen.png"/>
<img alt="screenshot" width="30%" src="assets/settingsScreen.png"/>
</p>

</br>
<p float="left" align="center">
<img alt="screenshot" width="80%" src="assets/panelControlFlippedScreen.png"/>
</p>



## Download
BADGE DA PLAYSTORE https://play.google.com/intl/en_us/badges/

Ou faça o download da <a href="apk/app-debug.apk?raw=true">APK diretamente</a>. Você pode ver <a href="https://www.google.com/search?q=como+instalar+um+apk+no+android">aqui</a> como instalar uma APK no seu aparelho android.

## Tecnologias usadas e bibliotecas de código aberto

- Minimum SDK level COLOQUE AQUI A APK MINIMA
- [Linguagem Kotlin](https://kotlinlang.org/)

- Jetpack 
  - Compose: Para escrever a UI de maneira programática com funções de composição que descrevem a forma e as dependências de dados dela. 
  - Lifecycle: Observe os ciclos de vida do Android e manipule os estados da interface do usuário após as alterações do ciclo de vida.
  - ViewModel: Gerencia o detentor de dados relacionados à interface do usuário e o ciclo de vida. Permite que os dados sobrevivam a alterações de configuração, como rotações de tela.
  - ViewBinding: Liga os componentes do XML no Kotlin através de uma classe que garante segurança de tipo e outras vantagens.
  - Room: Biblioteca de abstração do banco de dados SQLite que garante segurança em tempo de compilação e facilidade de uso.
  - Custom Views: View customizadas feitas do zero usando Jetpack Compose.
  - Hilt: Para injeção de dependências que reduz o código boilerplate criado por injeções manuais no projeto.

- Arquitetura 
  - MVVM (View - ViewModel - Model)
  - Comunicação da ViewModel com a View através de LiveData
  - Comunicação da ViewModel com a Model através de Kotlin Flow
  - Repositories para abstração da comunidação com a camada de dados.
  - Interfaces que são implementadas nos repositories para facilitar os testes unitários.
  
## Arquitetura
APRESENTE A ARQUITETURA UTILIZADA NO PROJETO
**Estudia** utiliza a arquitetura MVVM e o padrão de Repositories, que segue as [recomendações oficiais do Google](https://developer.android.com/topic/architecture).
</br></br>



<br>

## Features

### Feature 1
<img src="screenshots/feature-1.gif" width="25%"/>

Texto de exemplo

### Feature 2
<img src="screenshots/feature-2.gif" width="25%"/>

Texto de Exemplo.

# Licença

COLOQUE A LICENÇA - https://opensource.org/licenses

```xml

```
