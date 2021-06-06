package common.OrgAsset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrgAssetFileDataSourceTest {
    private OrgAssetFileDataSource OrgAssetTest;
    private static final OrgAsset A = new OrgAsset("a1", "a2", "a3");
    private static final OrgAsset B = new OrgAsset("b1", "b2", "b3");
    private static final OrgAsset C = new OrgAsset("c1", "c2", "c3");

    @BeforeEach
    public void initOrgAssetFileDataSourceTest(){
        OrgAssetTest = new OrgAssetFileDataSource();
    }

    @Test
    void addOrganization() {
        OrgAssetTest.addOrganization(A);
        OrgAssetTest.addOrganization(B);
        OrgAssetTest.addOrganization(C);
        OrgAssetTest.getSize();
        assertEquals(8, OrgAssetTest.getSize());
    }

    @Test
    void deleteOrganization() {
        OrgAssetTest.deleteOrganization(A.getUnitname());
        OrgAssetTest.deleteOrganization(B.getUnitname());
        OrgAssetTest.deleteOrganization(C.getUnitname());
        OrgAssetTest.getOrganization(A.getUnitname());
        OrgAssetTest.getOrganization(B.getUnitname());
        OrgAssetTest.getOrganization(C.getUnitname());
        assertEquals(5, OrgAssetTest.getSize());
    }
}