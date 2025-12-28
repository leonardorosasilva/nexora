# Nexora

Nexora é uma aplicação Kotlin Multiplatform (KMP) construída com Compose Multiplatform, permitindo compartilhamento de código entre Android e iOS. O projeto utiliza uma arquitetura limpa (Clean Architecture) com separação clara entre camadas de dados, domínio e apresentação.

## 📋 Índice

- [Tecnologias](#tecnologias)
- [Arquitetura](#arquitetura)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Pré-requisitos](#pré-requisitos)
- [Configuração](#configuração)
- [Executando o Projeto](#executando-o-projeto)
- [Estrutura de Dados](#estrutura-de-dados)
- [Desenvolvimento de UI](#desenvolvimento-de-ui)
- [Status do Projeto](#status-do-projeto)

## 🛠 Tecnologias

- **Kotlin Multiplatform** - Compartilhamento de código entre plataformas
- **Compose Multiplatform** - Framework de UI declarativa
- **Room Database** - Persistência local de dados
- **Koin** - Injeção de dependências
- **Ktor** - Cliente HTTP para comunicação com APIs
- **Kotlinx Serialization** - Serialização JSON
- **Voyager** - Navegação multiplataforma
- **Material 3** - Design system

## 🏗 Arquitetura

O projeto segue os princípios da **Clean Architecture**, organizando o código em três camadas principais:

### Camada de Domínio (`domain`)
- **Modelos**: Entidades de negócio (`User`, `Match`, `Meeting`, `Message`, `Insight`)
- **Repositórios**: Interfaces que definem contratos para acesso a dados
- **Use Cases**: Lógica de negócio (pasta `usecase` está vazia, pronta para implementação)

### Camada de Dados (`data`)
- **Repositórios**: Implementações concretas dos repositórios do domínio
- **Entities**: Entidades do Room Database (`UserEntity`, `MatchEntity`, etc.)
- **DAOs**: Data Access Objects para operações no banco de dados
- **Database**: Configuração do Room Database
- **Mappers**: Conversores entre entidades de dados e modelos de domínio
- **Remote**: Cliente HTTP e modelos remotos (pasta está vazia, pronta para implementação)

### Camada de Apresentação (`presentation`)
- **UI**: Composables do Compose (pasta não criada ainda)
- **ViewModels**: Gerenciamento de estado (não implementado ainda)

## 📁 Estrutura do Projeto

```
composeApp/src/commonMain/kotlin/com/nexora/
├── data/
│   ├── local/
│   │   ├── dao/          # Data Access Objects (Room)
│   │   ├── entity/       # Entidades do banco de dados
│   │   ├── database/     # Configuração do Room Database
│   │   └── converters/   # Type converters para Room
│   ├── mapper/           # Conversores Entity <-> Domain Model
│   ├── repository/       # Implementações dos repositórios
│   └── remote/           # API client (a ser implementado)
├── domain/
│   ├── model/            # Modelos de domínio
│   ├── repository/       # Interfaces dos repositórios
│   └── usecase/          # Casos de uso (a ser implementado)
├── presentation/         # (a ser criado)
│   ├── ui/               # Composables
│   └── viewmodel/        # ViewModels
└── App.kt                # Ponto de entrada da aplicação
```

## ⚙️ Pré-requisitos

- **Android Studio** (Hedgehog | 2023.1.1 ou superior) ou **IntelliJ IDEA**
- **JDK 11** ou superior
- **Xcode** 14+ (para desenvolvimento iOS - apenas macOS)
- **Kotlin** 2.1.0+
- **Gradle** 8.14.3+

## 🚀 Configuração

1. Clone o repositório:
```bash
git clone <repository-url>
cd Nexora
```

2. O projeto utiliza Gradle com version catalogs. As dependências estão configuradas em `gradle/libs.versions.toml`.

3. Para Android, certifique-se de ter o Android SDK configurado.

4. Para iOS, você precisa de um Mac com Xcode instalado.

## ▶️ Executando o Projeto

### Android

Para executar no Android:

```bash
./gradlew :composeApp:assembleDebug
```

Ou execute diretamente do Android Studio através da configuração de run.

### iOS

Para executar no iOS:

1. Abra o projeto no Xcode:
```bash
open iosApp/iosApp.xcodeproj
```

2. Selecione um simulador ou dispositivo e execute o projeto.

Ou execute diretamente do IntelliJ IDEA através da configuração de run (requer macOS).

## 📊 Estrutura de Dados

### Modelos de Domínio

- **User**: Usuários do sistema (id, name, email, username, photoUrl, bio, skills, goals, stage, status)
- **Match**: Conexões entre usuários (id, user1Id, user2Id, status)
- **Meeting**: Reuniões agendadas (id, match, title, description, date, status, participants)
- **Message**: Mensagens entre usuários (messageId, matchId, senderId, receiverId, text, timestamp)
- **Insight**: Insights/compartilhamentos (id, title, content, tags, status)

### Banco de Dados

O projeto utiliza **Room Database** para persistência local. O banco inclui as seguintes tabelas:
- `users`
- `matches`
- `meetings`
- `messages`
- `insights`

Todas as operações de banco de dados são realizadas através dos DAOs correspondentes.

## 🎨 Desenvolvimento de UI

### Status Atual da Estrutura

✅ **Bem estruturado para desenvolvimento de UI!**

O projeto possui uma base sólida para construção de interfaces:

1. **Camada de dados completa**: Todas as entidades, repositórios e mappers estão implementados
2. **Compose Multiplatform configurado**: Material 3, componentes de UI e recursos estão prontos
3. **Navegação preparada**: Voyager Navigator está incluído nas dependências
4. **Gerenciamento de estado**: Lifecycle ViewModel está configurado

### Próximos Passos para Desenvolvimento de UI

1. **Criar estrutura de apresentação**:
   ```
   presentation/
   ├── ui/
   │   ├── screens/
   │   │   ├── HomeScreen.kt
   │   │   ├── UserProfileScreen.kt
   │   │   ├── MatchListScreen.kt
   │   │   ├── ChatScreen.kt
   │   │   └── MeetingScreen.kt
   │   └── components/
   │       └── (componentes reutilizáveis)
   └── viewmodel/
       ├── UserViewModel.kt
       ├── MatchViewModel.kt
       └── (outros ViewModels)
   ```

2. **Configurar injeção de dependências (Koin)**:
   - Criar módulos para database, repositórios e ViewModels
   - Configurar Koin no ponto de entrada da aplicação

3. **Implementar navegação com Voyager**:
   - Configurar rotas
   - Integrar navegação entre telas

4. **Criar ViewModels**:
   - Implementar ViewModels usando `lifecycle-viewmodel-compose`
   - Conectar ViewModels aos repositórios

5. **Construir Composables**:
   - Criar telas usando Material 3
   - Implementar estados de loading, error e success
   - Adicionar navegação entre telas

### Exemplo de Estrutura Recomendada

```kotlin
// presentation/viewmodel/UserViewModel.kt
class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    var uiState by mutableStateOf(UserUiState())
        private set
    
    fun loadUser(id: String) {
        viewModelScope.launch {
            userRepository.getUserById(id)?.let {
                uiState = uiState.copy(user = it, isLoading = false)
            }
        }
    }
}

// presentation/ui/screens/UserProfileScreen.kt
@Composable
fun UserProfileScreen(
    userId: String,
    viewModel: UserViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState
    
    when {
        uiState.isLoading -> LoadingIndicator()
        uiState.user != null -> UserProfileContent(uiState.user)
        else -> ErrorMessage()
    }
}
```

## 📝 Status do Projeto

### ✅ Implementado
- [x] Estrutura de dados (Entities, DAOs, Database)
- [x] Repositórios e interfaces
- [x] Mappers entre camadas
- [x] Configuração do projeto KMP
- [x] Dependências principais

### 🚧 Em Desenvolvimento / Pendente
- [ ] Configuração de injeção de dependências (Koin)
- [ ] ViewModels
- [ ] Telas/Composables
- [ ] Navegação (Voyager)
- [ ] API Client (Ktor)
- [ ] Use Cases
- [ ] Testes unitários
- [ ] Tratamento de erros
- [ ] Loading states e error handling

## 🔧 Correções Realizadas

- ✅ Corrigido nome do arquivo `MessegeDao.kt` → `MessageDao.kt`
- ✅ Corrigido nome do arquivo `InsighEntity.kt` → `InsightEntity.kt`

## 📚 Documentação Adicional

- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Room Database](https://developer.android.com/training/data-storage/room)
- [Koin](https://insert-koin.io/)
- [Voyager](https://voyager.adriel.cafe/)

## 📄 Licença


---

**Desenvolvido com ❤️ usando Kotlin Multiplatform e Compose Multiplatform**
