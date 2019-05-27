package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_case")
public class Case extends AbstractCase {
}
