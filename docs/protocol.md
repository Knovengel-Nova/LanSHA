# Protocol Specification

LanSHA uses a compact application-layer protocol that mixes UDP and TCP so it can discover nearby devices efficiently while still delivering file transfers reliably.

## Transport split

- UDP is used for lightweight presence and discovery traffic.
- TCP is used for file transfer sessions and transfer negotiation.

This split is visible in the implementation of [src/main/java/com/amasp/lansha/protocol/PacketType.java](../src/main/java/com/amasp/lansha/protocol/PacketType.java).

## Packet categories

### UDP packets

| Packet | Purpose |
|---|---|
| DISCOVERY | Announces a newly started device to the local network. |
| DISCOVERY_REPLY | Replies to a discovery packet from another LAN participant. |
| HEART_BEAT | Keeps device presence up to date. |
| GOODBYE | Announces a graceful shutdown. |

### TCP packets

| Packet | Purpose |
|---|---|
| CONNECT | Establishes an application-level connection context. |
| FILE_REQUEST | Requests permission to send a file. |
| FILE_ACCEPT | Accepts a transfer request. |
| FILE_REJECT | Rejects a transfer request. |
| FILE_DATA | Sends the file payload in chunks. |
| ACK | Confirms application-level progress. |
| TRANSFER_COMPLETE | Signals that the transfer finished. |

## Packet structure

All packets inherit from the base packet model and carry shared fields such as:

- packet type
- device identifier
- device name
- TCP port

The serialization layer in [src/main/java/com/amasp/lansha/protocol/PacketSerializer.java](../src/main/java/com/amasp/lansha/protocol/PacketSerializer.java) converts Java packet objects into JSON for transport and reconstructs them on the receiving side.

## Message flow

A typical transfer follows this progression:

1. Discovery packets establish the device list.
2. A sender requests a transfer by sending a FILE_REQUEST packet.
3. The receiver may accept or reject it.
4. Once accepted, the sender streams FILE_DATA packets.
5. The transfer finishes with a TRANSFER_COMPLETE packet.

## Reference diagrams

The repo includes protocol-focused diagrams that match the implementation:

- [Protocol architecture](Images/ProtocolArchitecture.svg)
- [Protocol hierarchy](Images/ProtocolHierarchy.svg)
- [Packet format](Images/PacketFormat.svg)
- [Communication flow](Images/CommunicationFlow.svg)

## Design rationale

The protocol was designed to stay simple and readable while still supporting a real file-transfer workflow. JSON serialization is used to keep packet inspection easy during development, and the packet types are intentionally separated by transport to make the networking behavior easier to reason about.

## Planned enhancements

The protocol is expected to evolve with:

- AES-based encryption
- SHA-256 integrity checks
- resumable transfers
- better authentication and versioning
