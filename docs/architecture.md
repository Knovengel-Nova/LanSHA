# Architecture

LanSHA is structured as a modular desktop application with clear separation between the user interface, networking services, protocol definitions, and transfer management.

## High-level layout

The application is centered around a shared context object that is passed to the main runtime services. The startup path in [src/main/java/com/amasp/lansha/LanSHA.java](../src/main/java/com/amasp/lansha/LanSHA.java) initializes the device identity, creates the UI, and starts the discovery, heartbeat, janitor, and TCP listener services.

## Main layers

### 1. UI layer

The UI layer lives under [src/main/java/com/amasp/lansha/ui](../src/main/java/com/amasp/lansha/ui). It provides the Swing-based desktop experience for browsing devices, selecting files, and reviewing in-progress transfers.

### 2. Network layer

The network layer is implemented in [src/main/java/com/amasp/lansha/network](../src/main/java/com/amasp/lansha/network). It contains the background services that:

- discover other devices over UDP
- broadcast heartbeats to maintain presence
- listen for incoming TCP connections
- coordinate file transfer sessions

### 3. Protocol layer

The protocol layer in [src/main/java/com/amasp/lansha/protocol](../src/main/java/com/amasp/lansha/protocol) defines the packet hierarchy and serialization logic. LanSHA uses a shared base packet model and multiple concrete packet classes for UDP discovery and TCP transfer negotiation.

### 4. Transfer layer

Transfer coordination lives in [src/main/java/com/amasp/lansha/network/transfer](../src/main/java/com/amasp/lansha/network/transfer). This layer manages active transfer sessions, sender and receiver responsibilities, and transfer state updates.

### 5. Device and utility layer

Device identity, registry state, and metadata helpers are managed under [src/main/java/com/amasp/lansha/device](../src/main/java/com/amasp/lansha/device) and [src/main/java/com/amasp/lansha/util](../src/main/java/com/amasp/lansha/util).

## Runtime flow

1. The application starts and creates a device identity.
2. The UI is shown and the network services are started.
3. Discovery packets announce the local device to the LAN.
4. Nearby devices are tracked inside the device registry.
5. When a user initiates a transfer, a TCP session is created and the transfer manager coordinates the exchange.

## Reference diagrams

The documentation package includes SVG diagrams that visualize the architecture and protocol components:

- [Architecture overview](Images/Architecture.svg)
- [Architecture initialization flow](Images/ArchitectureInit.svg)
- [Communication flow](Images/CommunicationFlow.svg)
- [Connection handler flow](Images/ConnectionHandler.svg)
- [Heartbeat sender flow](Images/HeartBeatSender.svg)
- [Janitor lifecycle flow](Images/Janitor.svg)
- [Packet format](Images/PacketFormat.svg)
- [Protocol architecture](Images/ProtocolArchitecture.svg)
- [Protocol hierarchy](Images/ProtocolHierarchy.svg)
- [TCP acceptor flow](Images/TCPAcceptor.svg)
- [UDP listener flow](Images/UDPListener.svg)

## Design notes

The architecture emphasizes:

- separation of concerns between UI and networking
- modular components with single responsibilities
- straightforward packet-based communication
- a clear path for future enhancements such as encryption and resumable transfers

