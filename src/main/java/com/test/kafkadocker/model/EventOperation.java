/*
 author Anastasiya
 created on 29/08/2021
 */

package com.test.kafkadocker.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EventOperation {
    INSERT, UPDATE, DELETE
}
