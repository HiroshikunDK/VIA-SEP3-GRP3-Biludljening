package Shared;

import io.grpc.Context;

public class ContextKeys {
    public static final Context.Key<String> CUSTOMER_ID = Context.key("customerId");
    public static final Context.Key<String> ROLE = Context.key("role");
}
