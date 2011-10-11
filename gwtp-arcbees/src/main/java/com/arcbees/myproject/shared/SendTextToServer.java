/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.shared;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

@GenDispatch(isSecure = false)
public class SendTextToServer {

  @In(1) String textToServer;

  @Out(1) String response;

}
