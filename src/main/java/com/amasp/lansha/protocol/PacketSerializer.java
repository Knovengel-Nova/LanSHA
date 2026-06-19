package com.amasp.lansha.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author knovengel
 */
public final class PacketSerializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    private PacketSerializer() {
    }

    public static byte[] serialize(Object packet) throws Exception {
        return mapper.writeValueAsBytes(packet);
    }

    public static <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return mapper.readValue(data, clazz);
    }
}
