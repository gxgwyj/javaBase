package com.xyz.java.base.rpc;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;

public class BizService extends Activatable {

    protected BizService(ActivationID id, MarshalledObject<String> params) throws IOException, ClassNotFoundException {
        super(id, 0);
        String str = params.get();
    }
}
