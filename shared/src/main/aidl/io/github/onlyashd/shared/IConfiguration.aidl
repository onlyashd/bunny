package io.github.onlyashd.shared;

interface IConfiguration {
    /**
     * Send and retrieve data between apps.
     */
    Bundle getConfig(in Bundle data);
}