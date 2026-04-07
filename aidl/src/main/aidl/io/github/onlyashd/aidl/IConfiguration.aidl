package io.github.onlyashd.aidl;

interface IConfiguration {
    /**
     * Send and retrieve data between apps.
     */
    Bundle getConfig(in Bundle data);
}