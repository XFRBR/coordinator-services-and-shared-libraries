/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.scp.coordinator.keymanagement.shared.dao.common;

import com.google.common.collect.ImmutableList;
import com.google.scp.coordinator.protos.keymanagement.shared.backend.EncryptionKeyProto.EncryptionKey;
import com.google.scp.shared.api.exception.ServiceException;

/** Interface for Key database properties */
public interface KeyDb {

  /**
   * Returns active keys up to given keyLimit. Keys are sorted by expiration time in descending
   * order.
   */
  ImmutableList<EncryptionKey> getActiveKeys(int keyLimit) throws ServiceException;

  /** Returns all keys in the database without explicit ordering */
  ImmutableList<EncryptionKey> getAllKeys() throws ServiceException;

  /**
   * Performs a lookup of a single key, throwing a ServiceException if the key is not found.
   *
   * @param keyId the unique ID of the key (e.g. 'abcd123', not 'privateKeys/abcd123')
   */
  EncryptionKey getKey(String keyId) throws ServiceException;

  /** Create given key. */
  void createKey(EncryptionKey key) throws ServiceException;

  /** Create given keys. */
  void createKeys(ImmutableList<EncryptionKey> keys) throws ServiceException;

  /**
   * Thrown when the KeyDB record contains a Status field that does not match a value of
   * EncryptionKeyStatus enum.
   */
  class InvalidEncryptionKeyStatusException extends RuntimeException {

    public InvalidEncryptionKeyStatusException(String message) {
      super(message);
    }
  }
}
