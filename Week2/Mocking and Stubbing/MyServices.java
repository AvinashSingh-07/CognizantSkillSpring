//package Week-2.MockingandStubbing;
public class MyServices {

    private ExternalApi externalApi;

    public MyServices(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getdata();
    }
}
