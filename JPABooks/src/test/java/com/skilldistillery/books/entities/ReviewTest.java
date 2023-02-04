package com.skilldistillery.books.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Review rev;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPABooks");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();;
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		rev = em.find(Review.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rev = null;
	}

	@Test
	void test_Review_entity() {
		assertNotNull(rev);
		assertEquals("Excellent read", rev.getDescription());
		
	}

}
