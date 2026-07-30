# Developer Guide

This guide summarizes the structure of the LanSHA codebase so contributors can navigate the project quickly and understand the main extension points.

## Project layout

The Java sources are organized under [src/main/java/com/amasp/lansha](../src/main/java/com/amasp/lansha):

```text
src/main/java/com/amasp/lansha/
├── crypto/
├── device/
├── network/
│   └── transfer/
├── protocol/
│   ├── tcp/
│   └── udp/
├── ui/
│   └── panels/
├── util/
└── LanSHA.java
```

## Build and run

### Requirements

- Java 21+
- Maven
- A Java IDE such as NetBeans, IntelliJ IDEA, or VS Code with the Java extension pack

### Build

```bash
mvn clean package
```

### Run from the IDE

Use the main class [src/main/java/com/amasp/lansha/LanSHA.java](../src/main/java/com/amasp/lansha/LanSHA.java) as the application entry point.

### Run from the packaged jar

```bash
java -jar target/LanSHA-1.0.jar
```

## Key packages

| Package | Responsibility |
|---|---|
| device | Stores device metadata, registry state, and online/offline lifecycle information. |
| network | Provides discovery, heartbeat, janitor, listener, and connection services. |
| network.transfer | Coordinates active transfer sessions, senders, receivers, and transfer state. |
| protocol | Defines packet classes and serialization logic for the custom LAN protocol. |
| ui | Implements the Swing desktop interface and transfer-detail panels. |
| util | Contains shared helpers for file handling, metadata, networking, persistence, and application context. |
| crypto | Reserved for future encryption work and currently contains placeholder security classes. |

## Main runtime services

The application startup path shown in [src/main/java/com/amasp/lansha/LanSHA.java](../src/main/java/com/amasp/lansha/LanSHA.java) creates the device identity, initializes the UI, and starts the following services:

- DiscoveryService for initial LAN discovery
- UDPListener for incoming discovery, heartbeat, and goodbye packets
- HeartBeatSender for periodic presence updates
- Janitor for removing stale devices from the registry
- TCPAcceptor for incoming transfer connections

## Transfer workflow

The transfer flow is coordinated by [src/main/java/com/amasp/lansha/network/transfer/TransferManager.java](../src/main/java/com/amasp/lansha/network/transfer/TransferManager.java):

1. An incoming file request is turned into a transfer session.
2. The UI asks the user to approve or reject the transfer.
3. Once accepted, the transfer manager begins the sender or receiver side.
4. File data packets are exchanged until the transfer completes.

## Coding conventions

The project mostly follows straightforward Java conventions:

- PascalCase for class names
- camelCase for methods and variables
- uppercase names for constants where applicable
- package names in lowercase

## Extension ideas

If you want to contribute, the most natural extension points are:

- add a new packet type in the protocol package
- enhance the transfer manager for resumable transfers
- improve the UI panels in the ui package
- implement the planned encryption utilities in the crypto package

## Documentation references

- [README](../README.md)
- [Architecture](architecture.md)
- [Protocol Specification](protocol.md)
- [FAQ](faq.md)
- Diagrams in [docs/Images](Images)

- UDP is used only for discovery and device presence.
- TCP is used only for reliable file transfer.
- Serialization is centralized through `PacketSerializer`.

---

## Thread Safety

Networking services execute independently of the Swing Event Dispatch Thread.

Shared state is synchronized using appropriate concurrent data structures where required.

---

## Error Handling

Networking failures should:

- Fail gracefully.
- Never terminate the UI.
- Release resources correctly.
- Provide meaningful error messages.

---

# Future Refactoring

Several improvements have already been identified.

### Protocol

- Move `totalChunks` from `FileDataPacket` to `FileAcceptPacket`.
- Introduce protocol versioning.
- Add packet timestamps.

### Networking

- Better connection lifecycle management.
- Improved timeout handling.
- Performance optimizations.

### File Transfer

- AES encryption.
- SHA-256 integrity verification.
- Resumable transfers.
- Compression support.
- Transfer queue.

### User Interface

- Drag and drop.
- Additional themes.
- Better transfer history.
- Accessibility improvements.

---

# Contributing

When contributing to LanSHA:

- Keep classes focused on a single responsibility.
- Follow the existing package organization.
- Update documentation whenever protocol changes are introduced.
- Prefer readability over premature optimization.
- Test networking functionality across multiple devices whenever possible.

---

# Additional Documentation

- [Architecture](architecture.md)
- [Protocol Specification](protocol.md)
- [Roadmap](roadmap.md)

---

# Final Notes

LanSHA is designed to be both a practical LAN file sharing application and a learning project focused on networking, systems programming and software engineering.

Future development will continue to emphasize modularity, maintainability and a clean architecture while expanding the protocol with features such as encryption, integrity verification and resumable transfers.