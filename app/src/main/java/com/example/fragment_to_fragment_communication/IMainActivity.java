package com.example.fragment_to_fragment_communication;

public interface IMainActivity {
    void setToolbarTitle(String fragmentTag);

    void InflateFragment (String fragmentTag, String message);
}
