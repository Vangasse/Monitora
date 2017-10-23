package State;

public interface SearchState {

	SearchState forMonitors();
	
	SearchState forGroups();
	
	SearchState forSchools();
	
	SearchState forThemes();
}
