package common.OrgBalance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrgBalanceFileDataSourceTest {
    private OrgBalanceFileDataSource orgbalanceTest;
    private static final OrgBalance A = new OrgBalance("a1", "a2");
    private static final OrgBalance B = new OrgBalance("b1", "b2");
    private static final OrgBalance C = new OrgBalance("c1", "c2");


    @BeforeEach
    public void initOrgBalanceFileDataSourceTest()
    {
        orgbalanceTest = new OrgBalanceFileDataSource();
    }

    @Test
    void addOrganization() {
        orgbalanceTest.addOrganization(A);
        orgbalanceTest.addOrganization(B);
        orgbalanceTest.addOrganization(C);
        orgbalanceTest.getOrganization(A.getUnitname());
        orgbalanceTest.getOrganization(B.getUnitname());
        orgbalanceTest.getOrganization(C.getUnitname());
        orgbalanceTest.getSize();
        assertEquals(7, orgbalanceTest.getSize());
        
    }

    @Test
    void deleteOrganization() {
        orgbalanceTest.deleteOrganization(A.getUnitname());
        orgbalanceTest.deleteOrganization(B.getUnitname());
        orgbalanceTest.deleteOrganization(C.getUnitname());
        orgbalanceTest.getOrganization(A.getUnitname());
        orgbalanceTest.getOrganization(B.getUnitname());
        orgbalanceTest.getOrganization(C.getUnitname());
        orgbalanceTest.getSize();
        assertEquals(4, orgbalanceTest.getSize());
    }
}