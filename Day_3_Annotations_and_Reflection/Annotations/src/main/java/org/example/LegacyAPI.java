package org.example;

class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old Feature");
    }

    void newFeature() {
        System.out.println("New Feature");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
