package org.EpicGuys.ExpressJ;

import java.util.Map;

public interface HTTPPacket {
    public String getHTTPVersion();
    public String getHeader(String key);
    public Map<String, String> getHeaders();
}
