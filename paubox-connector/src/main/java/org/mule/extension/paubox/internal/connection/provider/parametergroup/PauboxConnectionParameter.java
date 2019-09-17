/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.internal.connection.provider.parametergroup;

import org.mule.runtime.api.tls.TlsContextFactory;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;

//import static org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED;
//import static org.mule.runtime.extension.api.annotation.param.display.Placement.ADVANCED_TAB;

public class PauboxConnectionParameter {

//	/**
//	 * Protocol to use for communication. Valid values are HTTP and HTTPS. Default value is HTTP. When using HTTPS the HTTP
//	 * communication is going to be secured using TLS / SSL. If HTTPS was configured as protocol then the user needs to configure
//	 * at least the keystore in the tls:context child element of this listener-config.
//	 */
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 1)
//	@Parameter
//	@Optional
//	@DisplayName("TLS Configuration")
//	private TlsContextFactory tlsContext;
//
//	/**
//	 * If false, each connection will be closed after the first request is completed.
//	 */
//	@Parameter
//	@Optional(defaultValue = "true")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 2)
//	private boolean usePersistentConnectionsPaubox;
//
//	/**
//	 * The maximum number of outbound connection that will be kept open at the same time. By default the number of connection is
//	 * unlimited.
//	 */
//	@Parameter
//	@Optional(defaultValue = "-1")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 3)
//	private Integer maxConnectionsPaubox;
//
//	/**
//	 * The number of milliseconds that a connection can remain idle before it is closed. The value of this attribute is only used
//	 * when persistent connection are enabled.
//	 */
//	@Parameter
//	@Optional(defaultValue = "60000")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 4)
//	private Integer connectionIdleTimeoutPaubox;
//
//	/**
//	 * Whether or not received responses should be streamed, meaning processing will continue as soon as all headers are parsed and
//	 * the body streamed as it arrives. When enabled, the response MUST be eventually read since depending on the configured buffer
//	 * size it may not fit into memory and processing will stop until space is available.
//	 */
//	@Parameter
//	@Optional(defaultValue = "false")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 4)
//	private boolean streamResponsePaubox;
//
//	/**
//	 * The space in bytes for the buffer where the HTTP response will be stored.
//	 */
//	@Parameter
//	@Optional(defaultValue = "-1")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 5)
//	private int responseBufferSizePaubox;
//
//	@Parameter
//	@Optional(defaultValue = "60000")
//	@Expression(NOT_SUPPORTED)
//	@Placement(tab = ADVANCED_TAB, order = 6)
//	private Integer connectionTimeoutPaubox;
//
//	@Parameter
//	@Placement(order = 2)
//	@Optional (defaultValue="no-cache")
//	private String cacheControl;
//
//	@Parameter
//	@Placement(order = 2)
//	@Optional (defaultValue="2.1.0")
//	private String pauboxAPIVersion;
//
//	@Parameter
//	@Placement(order = 2)
//	@Optional (defaultValue="paubox-borrower")
//	private String pauboxDeployment;
//
//	@Parameter
//	@Placement(order = 2)
//	@Optional (defaultValue="apisero")
//	private String pauboxSpecialInstanceId;
//
//
//	public TlsContextFactory getTlsContext() {
//		return tlsContext;
//	}
//
//	public boolean getUsePersistentConnectionsPaubox() {
//		return usePersistentConnectionsPaubox;
//	}
//
//	public Integer getMaxConnectionsPaubox() {
//		return maxConnectionsPaubox;
//	}
//
//	public Integer getConnectionIdleTimeoutPaubox() {
//		return connectionIdleTimeoutPaubox;
//	}
//
//	public boolean isStreamResponsePaubox() {
//		return streamResponsePaubox;
//	}
//
//	public int getResponseBufferSizePaubox() {
//		return responseBufferSizePaubox;
//	}
//
//	public Integer getConnectionTimeoutPaubox() {
//		return connectionTimeoutPaubox;
//	}
//
//	public String getCacheControl() {
//		return cacheControl;
//	}
//
//	public String getPauboxAPIVersion() {
//		return pauboxAPIVersion;
//	}
//
//	public boolean isUsePersistentConnectionsPaubox() {
//		return usePersistentConnectionsPaubox;
//	}
//
//	public String getPauboxDeployment() {
//		return pauboxDeployment;
//	}
//
//	public String getPauboxSpecialInstanceId() {
//		return pauboxSpecialInstanceId;
//	}
}
