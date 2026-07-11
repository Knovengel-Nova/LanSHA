# LanSHA Protocol Specification

**Navigation**

[README](../README.md) •
[Architecture](architecture.md) •
Protocol Specification •
[Developer Guide](developer-guide.md) •
[Roadmap](roadmap.md)

---

# Overview

LanSHA defines a lightweight application-layer protocol for automatic device discovery and reliable peer-to-peer file transfer over a Local Area Network (LAN).

The protocol combines **UDP** and **TCP**, using each where it is most suitable:

- **UDP** for lightweight discovery and device presence.
- **TCP** for reliable file transfer.

All packets inherit from a common `Packet` class and are serialized into JSON using Jackson before transmission.

---

# Protocol Architecture

The protocol implementation is organized according to the transport protocol.

```text
protocol/
│
├── Packet.java
├── PacketSerializer.java
├── PacketType.java
│
├── udp/
│   ├── DiscoveryPacket
│   ├── DiscoveryReplyPacket
│   ├── HeartBeatPacket
│   └── GoodByePacket
│
└── tcp/
    ├── ConnectPacket
    ├── FileRequestPacket
    ├── FileAcceptPacket
    ├── FileRejectPacket
    ├── FileDataPacket
    ├── ACKPacket
    └── TransferCompletePacket
```

---

# Packet Hierarchy

Every packet extends the common `Packet` base class.

```text
Packet
│
├── UDP Packets
│   ├── DiscoveryPacket
│   ├── DiscoveryReplyPacket
│   ├── HeartBeatPacket
│   └── GoodByePacket
│
└── TCP Packets
    ├── ConnectPacket
    ├── FileRequestPacket
    ├── FileAcceptPacket
    ├── FileRejectPacket
    ├── FileDataPacket
    ├── ACKPacket
    └── TransferCompletePacket
```

Shared packet fields:

| Field | Description |
|--------|-------------|
| packetType | Packet type identifier |
| deviceId | Sender UUID |
| deviceName | Sender device name |
| tcpPort | Sender TCP port |

---

# Communication Flow

```text
Application Starts
        │
        ▼
DISCOVERY
        │
        ▼
DISCOVERY_REPLY
        │
        ▼
Device Registry Updated
        │
        ▼
Periodic HEART_BEAT
        │
        ▼
User Selects Device
        │
        ▼
TCP Connection
        │
        ▼
FILE_REQUEST
        │
   ┌────┴────┐
   ▼         ▼
ACCEPT    REJECT
   │
   ▼
FILE_DATA
   │
   ▼
ACK
   │
   ▼
TRANSFER_COMPLETE
```

---

# UDP Protocol

UDP is responsible for **device discovery** and **presence management**.

It is used because:

- Supports broadcast communication.
- Low communication overhead.
- No connection establishment required.

LanSHA uses the following UDP packets.

| Packet | Purpose |
|---------|---------|
| DISCOVERY | Announces a newly started device. |
| DISCOVERY_REPLY | Responds to a discovery request. |
| HEART_BEAT | Indicates that a device is still online. |
| GOODBYE | Announces graceful shutdown. |

### Device Lifecycle

1. Device starts.
2. Broadcasts a **DISCOVERY** packet.
3. Existing devices respond with **DISCOVERY_REPLY**.
4. Devices periodically exchange **HEART_BEAT** packets.
5. Unknown heartbeat senders are automatically added to the Device Registry.
6. Missing heartbeats eventually remove inactive devices.
7. A **GOODBYE** packet immediately removes a device during graceful shutdown.

---

# TCP Protocol

TCP is responsible for reliable file transfer.

TCP was selected because it provides:

- Reliable delivery
- Ordered delivery
- Automatic retransmission
- Flow control

LanSHA defines the following TCP packets.

| Packet | Purpose |
|---------|---------|
| CONNECT | Application-level handshake. |
| FILE_REQUEST | Request permission to send a file. |
| FILE_ACCEPT | Accept a transfer request. |
| FILE_REJECT | Reject a transfer request. |
| FILE_DATA | Transfer file chunks. |
| ACK | Application-level acknowledgement. |
| TRANSFER_COMPLETE | Notify successful completion. |

---

# Packet Serialization

Every packet is represented as a Java object.

LanSHA uses the `PacketSerializer` utility together with the Jackson library to:

- Serialize packets into JSON.
- Deserialize received packets back into Java objects.

TCP packets are transmitted using a length-prefixed format.

```text
+--------------------+
| Packet Length (4B) |
+--------------------+
| JSON Packet Bytes  |
+--------------------+
```

This ensures that each received message can be reconstructed correctly.

---

# Reliability

The protocol separates discovery from file transfer.

### UDP

- Broadcast-based communication.
- Packet loss is acceptable.
- Heartbeats continuously refresh device state.

### TCP

- Reliable transport.
- Ordered delivery.
- Chunk-based file transfer.

Although TCP guarantees reliable delivery, LanSHA still uses application-level **ACK** packets to:

- Track transfer progress.
- Synchronize transfer state.
- Support future resumable transfers.

---

# Design Decisions

The protocol was designed around several core principles.

- UDP for lightweight discovery.
- TCP for reliable transfers.
- UUIDs instead of IP addresses for device identity.
- JSON for readability and extensibility.
- Shared `Packet` base class to reduce duplication.
- Chunk-based file transfer for scalability.

---

# Future Improvements

Planned protocol enhancements include:

- AES encrypted transfers.
- SHA-256 file integrity verification.
- Resumable transfers.
- Compression.
- Protocol versioning.
- Authentication.
- Parallel chunk transfer.

---

# Conclusion

LanSHA implements a modular application-layer protocol that combines UDP and TCP to provide automatic device discovery and reliable peer-to-peer file transfer.

The protocol emphasizes simplicity, maintainability, and extensibility while providing a solid foundation for future enhancements.