package com.amasp.lansha.network.transfer;

/**
 *
 * @author knovengel
 */
public enum TransferState {
    CONNECTING,
    WAITING_FOR_RESPONSE,
    TRANSFERRING,
    COMPLETED,
    ACCEPTED,
    REJECTED,
    CANCELLED,
    FAILED
}
