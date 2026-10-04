CREATE TABLE IF NOT EXISTS treatment_goals (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    treatment_plan_id UUID,
    description TEXT,
    target_date DATE,
    completed_at TIMESTAMP,
    notes TEXT,
    treatment_goal_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE treatment_goals ADD CONSTRAINT fk_treatment_goals_treatment_plan_id FOREIGN KEY (treatment_plan_id) REFERENCES treatment_plans(id);

ALTER TABLE treatment_goals ADD CONSTRAINT fk_treatment_goals_treatment_goal_id FOREIGN KEY (treatment_goal_id) REFERENCES treatment_goal_statuses(id);
