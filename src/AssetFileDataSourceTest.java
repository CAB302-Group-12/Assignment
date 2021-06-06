package common.Asset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssetFileDataSourceTest {
    private AssetFileDataSource assetTest;
    private static final Asset A = new Asset("a1", "a2", "a3", "a4", "a5", "a6");
    private static final Asset B = new Asset("b1", "b2", "b3", "b4", "b5", "b6");
    private static final Asset C = new Asset("c1", "c2", "c3", "c4", "c5", "c6");


    @BeforeEach
        public void initAssetFileDataSourceTest(){
        assetTest = new AssetFileDataSource();
    }

    @Test
    public void TestAddAsset() {
        assetTest.addAsset(A);
        assetTest.addAsset(B);
        assetTest.addAsset(C);
        assetTest.getAsset(A.getName());
        assetTest.getAsset(B.getName());
        assetTest.getAsset(C.getName());
        assetTest.getSize();
        assertEquals(7, assetTest.getSize());
    }


    @Test
    void deleteAsset() {
        assetTest.deleteAsset(A.getName());
        assetTest.deleteAsset(B.getName());
        assetTest.deleteAsset(C.getName());
        assetTest.getAsset(A.getName());
        assetTest.getAsset(B.getName());
        assetTest.getAsset(C.getName());
        assetTest.getSize();
        assertEquals(4, assetTest.getSize());
    }
}