-- Add parent_team_id column to teams table
ALTER TABLE teams ADD COLUMN parent_team_id BIGINT;

-- Add foreign key constraint for parent team
ALTER TABLE teams ADD CONSTRAINT fk_team_parent_team 
FOREIGN KEY (parent_team_id) REFERENCES teams(id);

-- Add index for better performance
CREATE INDEX idx_team_parent_team_id ON teams(parent_team_id);
