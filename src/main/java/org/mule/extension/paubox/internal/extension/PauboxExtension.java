package org.mule.extension.paubox.internal.extension;

import org.mule.extension.paubox.internal.error.ErrorTypes;
import org.mule.extension.paubox.internal.config.PauboxConfiguration;
import org.mule.extension.paubox.internal.connection.provider.PauboxConnectionProvider;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
//import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

import static org.mule.runtime.api.meta.Category.SELECT;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "paubox")
@Extension(name = "Paubox")
@Configurations(PauboxConfiguration.class)
@ConnectionProviders(PauboxConnectionProvider.class)
@org.mule.runtime.extension.api.annotation.error.ErrorTypes(ErrorTypes.class)
public class PauboxExtension {

}