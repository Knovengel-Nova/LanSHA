# LanSHA Developer Guide

**Navigation**

[README](../README.md) •
[Architecture](architecture.md) •
[Protocol](protocol.md) •
Developer Guide •
[Roadmap](roadmap.md)

---

# Overview

This document provides an overview of the LanSHA codebase for developers who wish to understand, maintain, or contribute to the project.

It explains the project structure, major components, coding conventions, and future refactoring plans.

For details regarding the communication protocol, refer to the **Protocol Specification**.

---

# Development Environment

## Requirements

- Java 23+
- Maven
- NetBeans IDE *(Recommended)*
- Git

---

## Clone

```bash
git clone https://github.com/Knovengel-Nova/LanSHA.git
```

---

## Build

```bash
mvn clean install
```

---

## Run

Launch the application using:

```text
LanSHA.java
```

---

# Project Structure

```text
src/
└── main/
    └── java/
        └── com.amasp.lansha/
            │
            ├── device/
            │   ├── DeviceInfo.java
            │   ├── DeviceRegistry.java
            │   └── DeviceStatus.java
            │
            ├── encrypt/
            │
            ├── network/
            │   ├── ConnectionHandler.java
            │   ├── DiscoveryService.java
            │   ├── HeartBeatSender.java
            │   ├── Janitor.java
            │   ├── TCPAcceptor.java
            │   ├── UDPListener.java
            │   │
            │   └── transfer/
            │       ├── TransferManager.java
            │       ├── TransferReceiver.java
            │       ├── TransferSender.java
            │       ├── TransferSession.java
            │       └── TransferState.java
            │
            ├── protocol/
            │   ├── tcp/
            │   ├── udp/
            │   ├── Packet.java
            │   ├── PacketSerializer.java
            │   └── PacketType.java
            │
            ├── ui/
            │   ├── panels/
            │   ├── MainFrame.java
            │   ├── UIFrame.java
            │   ├── SettingsFrame.java
            │   ├── Console.java
            │   └── ...
            │
            ├── util/
            │   ├── metadata/
            │   ├── Constants.java
            │   ├── FileUtil.java
            │   ├── LanSHAContext.java
            │   └── NetworkUtil.java
            │
            └── LanSHA.java
```

---

# Package Responsibilities

| Package | Responsibility |
|----------|----------------|
| **device** | Stores device information, device registry and device state. |
| **network** | Implements networking services including UDP discovery, TCP communication and file transfer. |
| **network.transfer** | Manages transfer sessions, sending, receiving and transfer state. |
| **protocol** | Defines packet types, packet hierarchy and packet serialization. |
| **ui** | Swing-based graphical user interface. |
| **util** | Shared utilities, constants, application context and metadata extraction. |
| **encrypt** | Reserved for future encryption support. |

---

# Runtime Components

LanSHA is composed of several independent services.

```text
                  User Interface
                        │
                        ▼
                Discovery Service
                        │
                UDP Broadcast / Listen
                        │
        ┌───────────────┴───────────────┐
        ▼                               ▼
 HeartBeat Sender                  Device Registry
        │                               ▲
        │                               │
        ▼                               │
      Janitor ──────────────────────────┘

                        │
                        ▼

                  TCP Acceptor
                        │
                        ▼
               Connection Handler
                        │
                        ▼
               Transfer Manager
               ├──────────────┐
               ▼              ▼
      Transfer Sender   Transfer Receiver
```

Each service performs a single responsibility and communicates through shared application state where appropriate.

---

# Core Components

## Discovery Service

Broadcasts discovery packets during application startup and processes discovery replies from nearby devices.

---

## UDP Listener

Continuously listens for incoming UDP packets including:

- Discovery
- Discovery Reply
- Heartbeat
- Goodbye

---

## HeartBeat Sender

Periodically broadcasts heartbeat packets so other devices can determine that this device is still online.

---

## Janitor

Runs periodically and removes inactive devices from the Device Registry when heartbeat timeout expires.

---

## TCP Acceptor

Listens for incoming TCP connections and delegates each connection to a dedicated `ConnectionHandler`.

---

## Connection Handler

Processes incoming TCP packets and coordinates file transfer operations.

---

## Transfer Manager

Coordinates file transfers and maintains transfer sessions.

---

## Packet Serializer

Responsible for serializing Java packet objects into JSON and reconstructing received JSON back into Java objects using the Jackson library.

---

# Design Principles

LanSHA follows several software engineering principles.

- Separation of Concerns
- Single Responsibility Principle
- Modular package organization
- Reusable packet hierarchy
- Clear separation between UDP and TCP communication
- Maintainable and extensible architecture

---

# Coding Conventions

## Naming

- PascalCase for classes
- camelCase for variables and methods
- UPPER_CASE for constants
- lowercase package names

---

## Networking

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